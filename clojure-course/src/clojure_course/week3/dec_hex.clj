(ns clojure-course.week3.dec-hex)

; generates a random number from 100 to 999
(def int_to_covert (+ 100 (rand-int 899)))
(def hex_letters {10 "A" 11 "B" 12 "C" 13 "D" 14 "E" 15 "F"})

(defn add_letter
  [number]
  (if (> number 9)
    (get hex_letters number)
    (str number)
    )
  )

(defn divide_with_remainder
  [value_to_divide hex_value]
  (let [qut (quot value_to_divide 16)
        remainder (rem value_to_divide 16)
        ; use this for debug
        ;_ (println "quot=" qut "; remainder=" remainder)
        hex_value (str (add_letter remainder) hex_value)
        ;_ (println "hex_value=" hex_value )
        ]
    (if (= qut 0)
      (str hex_value)
      (divide_with_remainder qut hex_value)
      )
    )
  )

(println "Integer to convert:" int_to_covert)
(println "My hex=" (divide_with_remainder int_to_covert ""))
(println (format "Clojure hex=%X" int_to_covert))

