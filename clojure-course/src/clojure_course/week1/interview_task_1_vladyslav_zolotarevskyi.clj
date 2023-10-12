(ns clojure-course.week1.interview-task-1-vladyslav-zolotarevskyi)

(load-file "src/clojure_course/week1/input_vector_interview_task1.clj")
(def vect clojure-course.week1.input_vector_interview_task1/input_vector)
(def target clojure-course.week1.input_vector_interview_task1/target)


(defn find-positions-that-add-up-to-target [vector target]
  (loop [idx 0
         positions {}
         remaining vector]
    (cond
      (empty? remaining) positions
      :else
      (let [current-element (first remaining)
            complement (- target current-element)]
        (if (contains? positions complement)
          (let [complement-idx (get positions complement)]
            [complement-idx idx])
          (recur (inc idx) (assoc positions current-element idx) (rest remaining))
          )
        )
      )
    )
  )


(print (time (let [positions (find-positions-that-add-up-to-target vect target)]
               (if (empty? positions)
                 (println "No elements found that add up to the target.")
                 (println "Positions of elements that add up to the target:" positions)))

             ))

(let [positions (find-positions-that-add-up-to-target vect target)]
  (if (empty? positions)
    (println "No elements found that add up to the target.")
    (println "Positions of elements that add up to the target:" positions)))

