(ns clojure-course.week5.fibonacci)

(defn fibonacci
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))
    )
  )

(println "fibonacci =" (fibonacci 8))
