(ns clojure-course.week2.interview-task-1-roman-yepanchenko)

(def integersCounter {})
(def integersIndexes {})

(defn process
  [integers]

  (doseq [[index, integer] (map-indexed vector integers)]

    ; if integersCounter map has an integer as a key then increment it counter
    ; else create a new key/value and fill integersIndexes map with a values index
    (if (contains? integersCounter integer)
      (do (def integersCounter (assoc integersCounter integer (+ 1 (get integersCounter integer)))))
      (do
        (def integersCounter (assoc integersCounter integer 1))
        (def integersIndexes (assoc integersIndexes integer index)))
      )
    )

  ; print
  (println
    ; loop-and-replace-values map that contains filtered values
    (map
      ; every map value now is a {integer: index}
      (fn [x] {x (get integersIndexes x)})
      ; creating new empty vector and filling it with filtered keys (integers) from integersCounter
      (into [] (keys (filter (fn [value]
                               (= (get value 1) 1)
                               ) integersCounter
                             ))
            ))
    )
  )

(process
  [11 34 5 78 11 78 14 5 34])
