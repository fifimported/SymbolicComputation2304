(ns clojure-course.week1.interview-task-1-anna-olexandra-danchenko)

(load-file "src/clojure_course/week1/input_vector_interview_task1.clj")

;(def vect [2 7 11 17 15])

(def vect clojure-course.week1.input_vector_interview_task1/input_vector)
(def target clojure-course.week1.input_vector_interview_task1/target)

;; Both functions assume that the vector given is not empty.

(defn find-index [vect target]
  (loop [count (dec (count vect))]
    ;;(println "First Loop") ;; Uncomment to see the iterations
    (when (>= count 0)
      (loop [count-rest
             (dec count)]
        ;;(println "Second Loop") ;; Uncomment to see the iterations
        (when (>= count-rest 0)
          (if (= target (+ (get vect count-rest) (get vect count)))
            (println "The indices are" count count-rest)
            (recur (dec count-rest)))))
      (recur (dec count)))))

;; This function is not effective as the function needs to go through the list in order to find the index of the vector.
(defn find-index-2 [vect target]
  (let [not-found? (ref true)]                              ;; Introducing a bool binding in order to stop the execution after the indices were found
    (loop [current-vect vect]
      (when (and (not-empty (rest current-vect)) (true? @not-found?))
        (loop [rest-elements (rest current-vect)]
          (when (not-empty rest-elements)
            (if (= (+ (first current-vect) (first rest-elements)) target)
              (dosync
                (println "The indices are"
                         (.indexOf vect (first current-vect)) ;; .indexOf is a Java Interop (Unfortunately had to use it in this case)
                         (.indexOf vect (first rest-elements)))
                (ref-set not-found? false))
              (recur (rest rest-elements)))))
        (recur (rest current-vect))))
    (when (true? @not-found?))))

(print (time (find-index vect target)))
(print (time (find-index-2 vect target)))

