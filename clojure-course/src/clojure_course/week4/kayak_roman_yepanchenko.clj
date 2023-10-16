(ns clojure-course.week4.kayak-roman-yepanchenko)

(def inputStringLength 0)
(def halfOfStringLength 0)

(def p1 0)
(def p2 0)
(def state true)

(defn init
  [inputString]
  (def inputStringLength (count inputString))

  (if (odd? inputStringLength)
    (do
      (def halfOfStringLength (+ (/ (- inputStringLength 1) 2) 1))
      )
    (do
      (def halfOfStringLength (/ inputStringLength 2))
      )
    )

  (def p2 (- inputStringLength 1))

  (doseq [i (for [i (range halfOfStringLength)] (inc i))]
    (if (not (= (get inputString p1) (get inputString p2)))
      (do
        (def state false)
        (println "IS NOT")
        )
      )

    (def p1 (+ p1 1))
    (def p2 (- p2 1))
    )

  ;(println (quot  (count inputString) 2))
  (println state)
  )

(init "kayak")
