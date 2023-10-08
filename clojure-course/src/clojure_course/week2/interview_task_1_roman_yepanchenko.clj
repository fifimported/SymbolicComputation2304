(ns clojure-course.week2.interview-task-1-roman-yepanchenko)

(def integersCounter {})

(defn process
  [integers]

  (doseq [integer integers]

    ; if integersCounter map has an integer as a key then increment it counter
    ; else create a new key/value
    (if (contains? integersCounter integer)
      (def integersCounter (assoc integersCounter integer (+ 1 (get integersCounter integer))))
      (def integersCounter (assoc integersCounter integer 1)))
    )

  ; creating new empty map and filling it with filtered value from integersCounter
  (println (into {} (filter (fn [value]
                              (= (get value 1) 1)
                              ) integersCounter
                            )
                 )
           )
  )

(process
  [11 34 5 78 11 78 14 5 34])
