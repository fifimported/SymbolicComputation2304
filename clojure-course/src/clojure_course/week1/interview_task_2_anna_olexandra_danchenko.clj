(ns clojure-course.week1.interview-task-2-anna-olexandra-danchenko)

(def prices [7 1 5 3 6 4])

(defn find-max-profit [prices]
  (with-local-vars [buy-price ##Inf
                    buy-day 0
                    max-profit 0
                    max-profit-day 0
                    counter 1
                    buy-day-final 1]
    (doseq [current-price prices]
      (cond
        (< current-price @buy-price) (do
                                       (var-set buy-price current-price)
                                       (var-set buy-day @counter))
        (> (- current-price @buy-price) @max-profit) (do
                                                       (var-set max-profit (- current-price @buy-price))
                                                       (var-set max-profit-day @counter)
                                                       (var-set buy-day-final @buy-day)))
      (println "day" @counter "buy-price" @buy-price "max-profit" @max-profit)
      (var-set counter (inc @counter)))
    (println "Buy on day" @buy-day-final "sell on day" @max-profit-day)))

(find-max-profit prices)