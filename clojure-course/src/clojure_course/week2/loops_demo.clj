(ns clojure-course.week2.loops-demo)

(def x 5)

(defn if_func
  []
  (if (= x 5)
    (println "x equals 5")
    (println "x not equals 5")
    )
  )

(defn if_func_mult
  []
  (if (= x 5)
    (do (println "x equals 5")
        (println "let's do something"))
    (do (println "x not equals 5")
        (println "let's do something"))
    )
  )

(defn when_func
  []
  (when (= 5 x)
    (println "x equals 5")
    )
  )

(defn cond_func
  []
  (cond
    (< x 3) "x has another value"
    (= x 5) (println "x equals 5")
    :else 42
    )
  )

(defn case_func
  []
  (case x
    3 ("x equals 3")
    5 (println "x equals 5")
    )
  )

(if_func)
;(if_func_mult)
;(when_func)
;(cond_func)
;(case_func)







