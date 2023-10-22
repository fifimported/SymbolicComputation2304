(ns clojure-course.microtasks.microtask001.solutions.kenneth-kofi-asare)

(defn total-toes []
  (let [front-paws-toes 5
        back-paws-toes 4]
    (+ (* 2 front-paws-toes) (* 2 back-paws-toes))))

(defn main []
  (println "My toes are" (total-toes)))



(main)
