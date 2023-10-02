(ns clojure-course.week2.sorting-hat)

(def students ["Harry Potter" "Ron Weasley" "Hermione Granger" "Draco Malfoy" "Neville Longbottom" "Luna Lovegood"])

; Functions must be declared before call
(defn hat-to-decide-if
  [probability]
  (if (and (<= 0 probability) (< probability 25))
    "Gryffindor"
    (if (and (<= 25 probability) (< probability 50))
      "Ravenclaw"
      (if (and (<= 50 probability) (< probability 75))
        "Hufflepuff"
        (if (and (<= 75 probability) (< probability 90))
          "Slytherin"
          "agriculture school in Prerov"
          )
        )
      )
    )
  )

(defn hat-to-decide-cond
  [probability]
  (cond
    (<= probability 25) "Gryffindor"
    (<= probability 50) "Ravenclaw"
    (<= probability 75) "Hufflepuff"
    (<= probability 90) "Slytherin"
    :else "agriculture school in Prerov"
    )
  )

(defn sorting-ceremony
  ; this argument shadows the external vector
  [students]
  (doseq [student_name students]
    (let [probability (rand-int 100)]
      (let [house_name (hat-to-decide-if probability)
            ;house_name (hat-to-decide-cond probability)
            ]
        (println student_name "assigned to house" house_name)
        (println "Congratulations!")
        )
      )
    )
  )

(sorting-ceremony students)



