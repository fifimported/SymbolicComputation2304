(ns clojure-course.week1.interview-task-1)

(load-file "src/clojure_course/week1/input_vector_interview_task1.clj")

;(def vect [2 7 11 15])
(def vect clojure-course.week1.input_vector_interview_task1/input_vector)
(def target clojure-course.week1.input_vector_interview_task1/target)
(def len (count vect))
(def found (atom false))

(println "Vector length =" len)
(println "Target =" target)

(defn find_two_numbers
  []
  (loop [i 0]
    (when (and (= @found false) (< i len))
      (loop [j 0]
        (when (and (= @found false) (< j len))
          (when (not= i j)
            (let [
                  v1 (get vect i)
                  v2 (get vect j)
                  ]
              (when (and
                      (= target (+ v1 v2 ))
                      )
                (println "Result: Pos1 =" i "| Pos2 =" j "| Val1 =" v1 "| Pos2 =" v2)
                (reset! found true)
                )
              )
            )
          (recur (inc j))
          )
        )
      (recur (inc i))
      )
    )
  )


(print (time (find_two_numbers)))







