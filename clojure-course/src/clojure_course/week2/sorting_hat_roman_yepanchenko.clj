(ns clojure-course.week2.sorting-hat-roman-yepanchenko)

(defn printStudentInfo
  [score, value]

  (if (and (>= score 0) (< score 25))
    (println {"Gryffindor" value, "score" score})
    )

  (if (and (>= score 25) (< score 50))
    (println {"Raven Claw" value, "score" score})
    )

  (if (and (>= score 50) (< score 75))
    (println {"Hufferpuff" value, "score" score})
    )

  (if (and (>= score 75) (< score 100))
    (println {"Slyth" value, "score" score})
    )

  (println "Congratulation!")
  )

(defn process
  [values]

  (doseq [value values]
    (def score (rand-int 100))

    (printStudentInfo score value)
    )

  )

(process ["Harry Potter" "Ron Weasley" "Hermione Granger" "Draco Malfoy" "Luna Lovegood"] )
