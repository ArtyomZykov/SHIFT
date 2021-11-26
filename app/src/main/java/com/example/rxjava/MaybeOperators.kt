package com.example.rxjava

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


object MaybeOperators {

	object Task1 {

		/**
		 * Вернуть пустой Maybe, который мгновенно завершит работу.
		 */
		fun solve(): Maybe<String> =
			Maybe.empty()
	}

	object Task2 {

		/**
		 * Преобразовать результат получаемый из [worker] в Maybe поток.
		 */
		fun solve(worker: Worker): Maybe<String> =
			TODO()
			// Maybe.create(worker.setResultListener {  })

		interface Worker {

			fun setResultListener(listener: (String?) -> Unit)
		}
	}

	object Task3 {
		/**
		 * Завершать поток, если в [source] будет отрицательное число.
		 * Возвращать значение, если оно будет положительным.
		 */
		fun solve(source: Single<Int>): Maybe<Int> =
			TODO()
	}

	object Task4 {

		/**
		 * Если [first] поток не вернет значение, то переключить на [second] поток.
		 */
		fun solve(first: Maybe<Int>, second: Single<Int>): Single<Int> =
			first.switchIfEmpty(second)
	}
}