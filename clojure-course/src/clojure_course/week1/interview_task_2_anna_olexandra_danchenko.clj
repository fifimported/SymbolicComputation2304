(ns clojure-course.week1.interview-task-2-anna-olexandra-danchenko)

(defn min-max [prices]
  (with-local-vars
    [min ##Inf max 0
     min-ind nil max-ind nil
     counter 0]                                             ;; Could also be implemented using dotimes and retrieving the elements from the vector based on the indices. Is there any other options?
    (doseq [price prices]
      (cond
        (< price @min) (do
                         (var-set min price)
                         (var-set max 0)
                         (var-set min-ind @counter))
        (>= price @max) (do
                          (var-set max price)
                          (var-set max-ind @counter)))
      (var-set counter (inc @counter)))
    (if (< @min-ind @max-ind)
      (println "Buy on day" (inc @min-ind) "sell on day" (inc @max-ind))
      0)))

;; The performance of this algorithm can not be improved further, as we need to go through the vector one by one in order.
(min-max [7 1 5 3 6 4])


