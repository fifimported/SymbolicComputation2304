(ns clojure-course.week5.mafia-boss-roman-yepanchenko)

(def henchmen
  {
   1 [100 200]
   2 [250 300]
   3 [400 100]
   }
  )


(defn calculate
  [henchmen index]

  (if (<= index (count henchmen))
    (do
      (+  (+ (apply + (get henchmen index))) (calculate henchmen (+ index 1)))
      )

    (do
      0
      )
    )

  )
(println (calculate henchmen, 1))
