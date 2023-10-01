(ns clojure-course.week1.interview-task-1)

(def vect [2 7 11 15])
(def target 18)
(def len (count vect))
(def found (atom false))

(println "Vector length =" len)
 (loop [i 0]
  (when (and (= @found false) (< i len))
    (loop [j 0]
      (when (and (= @found false) (< j len))
        (when (not= i j)
            (when (and
                    (= target (+ (get vect i) (get vect j) ))
                    )
              (println "Found=>" i j)
              (reset! found true)
              )
          )
        (recur (inc j))
      )
    )
    (recur (inc i))
    )
  )






