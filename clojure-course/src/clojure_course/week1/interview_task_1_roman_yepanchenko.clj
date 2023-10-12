(ns clojure-course.week1.interview-task-1-roman-yepanchenko)

(load-file "src/clojure_course/week1/input_vector_interview_task1.clj")
(def vect clojure-course.week1.input_vector_interview_task1/input_vector)
(def target clojure-course.week1.input_vector_interview_task1/target)

(defn process
  [values target]

  ;(println "vector" values)

  (def stateCompleted false)

  (doseq [[i1 value] (map-indexed vector values)]
    (def score value)
    (def indexes [i1])
    (def numbers [value])
    ;(println "start" value)

    (when (= stateCompleted false)
      (doseq [[i2 value2] (map-indexed vector values)]
        (when (> i2 i1)
          (when (= stateCompleted false)
            (def temp (+ score value2) )

            (when (<= temp target)
              (def score temp)

              (def indexes (conj indexes i2))
              (def numbers= (conj numbers value2))

              ;(println "no" temp)
              ;(println "===" numbers)
              )

            (when (= score target)
              (def stateCompleted true)
              (println "found" score)
              (println "indexes" indexes)
              )
            )
          )
        )
      )
    )
  )


(print (time (process vect target)))

;(process [2 7 11 15] 18)
;
;(doseq [value (reverse(sort values))]
;  (def firstIndex 0)
;
;  (calculate values firstIndex)
;
