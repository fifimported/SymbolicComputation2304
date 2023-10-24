(ns clojure-course.microtasks.microtask001.solutions.deniz-osman)

(defn count-dog's-paws []
  (let [front-paws 5
        back-paws 4
        total-amount (* 2 (+ front-paws back-paws))]
    (str "I have "total-amount" paws in total." )))

(println (count-dog's-paws))
