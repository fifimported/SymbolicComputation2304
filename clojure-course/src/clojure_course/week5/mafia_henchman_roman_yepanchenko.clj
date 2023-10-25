(ns clojure-course.week5.mafia-henchman-roman-yepanchenko)

(def tribute_payers
  [
   ["Bar" 200]
   [
    ["hotdog stall" 100]
    [
     ["repair shop" 200]
     ["grocery shop" 300]
     ["disco club" 250]
     ]
    ["pawnshop" 400]
    ]
   ]
  )


(defn calculate
  [tribute_payers]

  (let [sum (atom 0)]

    (if (vector? (get tribute_payers 0))
      (do
        (doseq [value, tribute_payers]
          (reset! sum (+ (calculate value) @sum))
          )
        )
      (do
        (reset! sum (+ (get tribute_payers 1) @sum))
        )
      )

    @sum
    )
  )
(let [
      sum (atom 0)
      ]

  (reset! sum (calculate tribute_payers))

  (println @sum)
  (println (/ @sum 10))
  )
