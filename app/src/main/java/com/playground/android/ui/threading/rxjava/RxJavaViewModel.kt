package com.playground.android.ui.threading.rxjava

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class RxJavaViewModel @Inject constructor() : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    private val _threadingState = MutableLiveData<String>()
    val threadingState: LiveData<String>
        get() = _threadingState

    private val strings = listOf("Test 1", "Test 2")
    private val integers = listOf(1, 2, 3, 4, 5)
    private val observable = Observable.create {
        for (data in integers) {
            if (!it.isDisposed) {
                it.onNext(data)
            }
        }
        if (!it.isDisposed) {
            it.onComplete()
        }
    }

    fun rxCreate() {
        val observable = Observable.create { emitter ->
            try {
                for (item in strings) {
                    emitter.onNext(item)
                }
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                _threadingState.postValue("onSubscribe")
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                _threadingState.postValue(t)
                println(t)
            }

            override fun onError(e: Throwable) {
                _threadingState.postValue(e.message)
                println(e.message)
            }

            override fun onComplete() {
                _threadingState.postValue("onComplete")
                println("onComplete")
            }
        }

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun rxDefer() {
        val deferData = DeferClass()
        deferData.setTextValue("Halo")
        deferData.valueObservable()
            .subscribe({
                _threadingState.postValue(it)
                println("Defer: $it")
            }, {
                _threadingState.postValue(it.message)
                print("Defer: ${it.message}")
            }).addTo(compositeDisposable)
    }

    class DeferClass {
        private var textValue: String = ""

        fun setTextValue(data: String) {
            textValue = data
        }

        fun valueObservable(): Observable<String> {
            return Observable.defer {
                Observable.just(textValue)
            }
        }
    }

    fun rxBuffer() {
        Observable.just("A", "B", "C", "D")
            .buffer(2)
            .subscribe(object : Observer<List<String>> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: List<String>) {
                    println("onNext")
                    for (s in t) {
                        println(s)
                    }
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

    fun rxMap() {
        observable
            .map { it * 2 }
            .subscribeOn(Schedulers.io())
            .doOnNext { println("Map: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxFlatMap() {
        observable
            .flatMap { getModifiedObservable(it) }
            .subscribeOn(Schedulers.io())
            .doOnNext { println("FlatMap: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxSwitchMap() {
        observable
            .switchMap { getModifiedObservable(it) }
            .subscribeOn(Schedulers.io())
            .doOnNext { println("SwitchMap: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxConcatMap() {
        observable
            .concatMap { getModifiedObservable(it) }
            .subscribeOn(Schedulers.io())
            .doOnNext { println("ConcatMap: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxGroupBy() {
        observable
            .groupBy { it % 2 == 0 }
            .subscribeOn(Schedulers.io())
            .flatMapMaybe { group ->
                group.reduce { t1: Int, t2: Int ->
                    t1 + t2
                }.map {
                    "Group " + group.key + " sum is " + it
                }
            }
            .doOnNext { println("GroupBy: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxScan() {
        observable
            .scan { t1: Int, t2: Int ->
                t1 + t2
            }
            .doOnNext { println("Scan: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    @SuppressLint("CheckResult")
    fun rxCombinedLatest() {
        val observable1 = Observable.range(0, 4).doOnNext {
            println("obv1: $it")
        }
        val observable2 = Observable.range(0, 9).doOnNext {
            println("obv2: $it")
        }
        val observable3 = Observable.range(0, 14).doOnNext {
            println("obv3: $it")
        }
        Observable.combineLatest(
            observable1,
            observable2,
            observable3
        ) { t1: Int, t2: Int, t3: Int ->
            "CombineLatest: observable1 = $t1 observable2 = $t2 observable3 = $t3"
        }.subscribe {
            println(it)
        }.addTo(compositeDisposable)
    }

    fun rxJoin() {
        val left = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS)
        val right = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS)

        left.join(right,
            {
                Observable.timer(0, TimeUnit.SECONDS)
            },
            {
                Observable.timer(0, TimeUnit.SECONDS)
            },
            { l: Long, r: Long ->
                println("Left result: $l Right Result: $r")
                l + r
            })
            .doOnNext {
                println("onNext: $it")
            }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxMerge() {
        val obv1 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "A$it" }
        val obv2 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "B$it" }

        Observable.merge(obv1, obv2)
            .doOnNext { println("Merge: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxConcat() {
        val obv1 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "A$it" }
        val obv2 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "B$it" }

        Observable.concat(obv1, obv2)
            .doOnNext { println("Concat: $it") }
            .subscribe()
            .addTo(compositeDisposable)
    }

    fun rxZip() {
        val obv1 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "A$it" }
        val obv2 = Observable.intervalRange(0, 10, 0, 100, TimeUnit.MILLISECONDS).map { "B$it" }

        Observable.zip(
            obv1,
            obv2
        ) { t1, t2 ->
            "Zip: $t1 $t2"
        }
            .doOnNext {
                println(it)
            }
            .subscribe()
            .addTo(compositeDisposable)
    }

    private fun getModifiedObservable(data: Int): Observable<Int> {
        return Observable.create {
            it.onNext(data * 2)
            it.onComplete()
        }.delay((100L..1000L).random(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
    }

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onCleared()
    }
}