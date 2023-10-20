(ns clojure-course.week4.sliding-window-roman-yepanchenko)

(def p1 0)
(def p2 1)
(def state true)
(def maxIndex 0)

(def response [p1 p2])

(def currentSum 0)

(defn init
  [inputValues, maxSum]
  (def maxIndex (- (count inputValues) 1))

  (def currentSum (+ (get inputValues p1) (get inputValues p2)))

  (while (= state true)
    (if (>= currentSum maxSum)
      (do
        (def currentSum (- currentSum (get inputValues p1)))

        (def p1 (+ p1 1))
        )

      (do
        (if (<= (+ p2 1) maxIndex)
          (do
            (def p2 (+ p2 1))

            (def currentSum (+ currentSum (get inputValues p2)))

            (if (and (<= currentSum maxSum) (> (+ (- p2 p1) 1) (+ (- (get response 0) (get response 1)) 1)))
              (def response [p1, p2])
              )
            )

          (do
            (def state false)
            )
          )
        )
      )
    )

  (println "Sum" (apply + (subvec inputValues (get response 0) (+ (get response 1) 1))))
  (println "p1,p2" response)
  (println "values" (subvec inputValues (get response 0) (+ (get response 1) 1)))

  (println "Length" (+ (- (get response 1) (get response 0)) 1))
  )

(init [3 2 1 3 1 1] 5)
;(init [64 64 128 32 16 8 16 32 128] 256)
