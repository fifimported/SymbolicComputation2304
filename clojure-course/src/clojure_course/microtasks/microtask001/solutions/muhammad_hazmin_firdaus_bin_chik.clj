(ns clojure-course.microtasks.microtask001.solutions.muhammad-hazmin-firdaus-bin-chik)

(def toes (+ (* 2 5) (* 2 4)))

(println "The number of toes that Sweet Bun has:" toes)

(defn toes2
  [front_paw back_paw]
  (let [front_leg 2
        back_leg 2
        total (+ (* front_paw front_leg) (* back_paw back_leg))
        ]
    (println "The total number of Sweet Bun toes:" total)
    )
  )

(toes2 5 4)
