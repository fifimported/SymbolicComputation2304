(ns clojure-course.week1.interview-task-1-kirill-marchenko)


(defn AddValue [Vector Target]

  (doseq [index1 (range (count Vector))]
    (let [i (if (> (count Vector) (inc index1)) (inc index1) index1)]
      (doseq [index2 (range i, (count Vector))]
        (let [val1 (get Vector index1)
              val2 (get Vector index2)]
          (if (= (+ val1 val2) Target)
            (println "Indexes:" index1 index2 "Values:" val1 val2)))))
    )
  )

(def vect clojure-course.week1.input_vector_interview_task1/input_vector)
(def target clojure-course.week1.input_vector_interview_task1/target)

(def my-vector [1 2 3 4 5])

(def my-target 7)


;(AddValue my-vector2 my-target2)
;(AddValue vect target)

(print (time (AddValue vect target)))


