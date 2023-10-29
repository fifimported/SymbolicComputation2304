(ns clojure-course.microtasks.microtask002.solutions.kenneth-asare)

(defn calculate-paint [length width]
  (* length width 2))

(def dragon-parts
  [
   [2 3] ;; Head and Neck
   [5 4] ;; Body and Paws
   [1 3] ;; Tail
   ])

(defn paint-needed [dragon-parts]
  (let [areas (map (fn [[length width]] (apply calculate-paint [length width])) dragon-parts)]
    (apply + areas)))

(let [total-paint (paint-needed dragon-parts)]
  (println "The number of paint Xavier will need is" total-paint))




