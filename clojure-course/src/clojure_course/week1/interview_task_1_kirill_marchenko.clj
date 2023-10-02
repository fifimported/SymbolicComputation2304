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

(def my-vector [1 2 3 4 5])
(def my-vector2 [2 7 11 15])
(def my-target 7)
(def my-target2 18)

(AddValue my-vector2 my-target2)


