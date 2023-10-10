(ns clojure-course.week3.dex-hex-roman-yepanchenko)

(def transferTable {
                    10 "A"
                    11 "B"
                    12 "C"
                    13 "D"
                    14 "E"
                    15 "F"
                    })

(def response [])

(defn formatResponse
  [values]
  (apply str (into [] (reverse (map (fn [x]
                                      (if (<= x 9)
                                        x
                                        (get transferTable x)
                                        )
                                      ) values)))))

(defn process
  [value]

  (def dividerMod (mod value 16))
  (def dividerCounter (/ (- value dividerMod) 16))

  (def response (conj response dividerMod))

  (if (= dividerCounter 0)
    (do
      (println "Generated hex =" (formatResponse response))
      )
    (process dividerCounter)
    )
  )

(defn init
  [value]

  (println "Clojure Hex =" (format "%X" value))
  (process value)
  (println (= (formatResponse response) (format "%X" value)))
  )
(init 1074)



