(ns clojure-course.week2.interview-task-2-roman-yepanchenko)

(def integersCounter {})

(defn process
  [integers]

  (doseq [integer integers]

    ; if integersCounter map has an integer as a key then increment the counter
    ; else create a new key/value
    (if (contains? integersCounter integer)
      (def integersCounter (assoc integersCounter integer (+ 1 (get integersCounter integer))))
      (def integersCounter (assoc integersCounter integer 1)))
    )

  ; creating new empty map and filling it with filtered value from integersCounter then count the map length
  (println (count (into {} (filter (fn [value]
                                     (not (= (get value 1) 1))
                                     ) integersCounter
                                   )
                        ))
           )
  )

(process
  [11 34 5 78 11 74 14 8 34])
