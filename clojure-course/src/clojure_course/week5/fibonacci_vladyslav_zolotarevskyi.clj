(ns clojure-course.week5.fibonacci-vladyslav-zolotarevskyi)

(defn fibonacci [n]
  (loop [f1 0
         f2 1
         count 0]
    (if (<= count n)
      (do
        (println f1)
        (recur f2 (+ f1 f2) (inc count)))
      nil)))

(fibonacci 10)
