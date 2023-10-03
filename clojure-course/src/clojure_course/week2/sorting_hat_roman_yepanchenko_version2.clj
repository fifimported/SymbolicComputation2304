(ns clojure-course.week2.sorting-hat-roman-yepanchenko-version2)

; The first version of the program had a set of hardcoded conditions. Then I refactored it
; that made the program flexible. Now the process function have two args:
;  array of schools, where every school is a map that have a name and a score range
;  array of students, just strings
;
; Now we can configure schools and students sets without pain.
;
; ================================================
;
; Below is the original conditions of schools choosing algorithm. Actually,
; it's a more suitable realization due the homework description, but it's a bit dirty
; because it's should be hardcoded.
;
;(cond
;  (and (>= score 0) (< score 20)) (println {"Gryffindor [0-19]" value, "score" score})
;  (and (>= score 20) (< score 40)) (println {"Raven Claw [20-39]" value, "score" score})
;  (and (>= score 40) (< score 60)) (println {"Hufflepuff [40-59]" value, "score" score})
;  (and (>= score 60) (< score 80)) (println {"Slytherin [60-79]" value, "score" score})
;  (and (>= score 80) (<= score 100)) (println {"škola zemědělská, Přerov [80-100]" value, "score" score})
;  :else (println "no school for your score)


(defn printStudentInfo
  [schools studentScore, studentName]

  (doseq [school schools]
    (def schoolName (get school "name"))
    (def schoolRange (get school "range"))
    (def schoolPrintData {
                          "schoolName"   schoolName
                          "schoolRange"  schoolRange
                          "studentName"  studentName
                          "studentScore" studentScore
                          })

    (def isStudentScoreIsAcceptableForSchool (and (>= studentScore (get schoolRange 0)) (< studentScore (get schoolRange 1))))

    (cond
      isStudentScoreIsAcceptableForSchool (println schoolPrintData)
      )

    (cond
      isStudentScoreIsAcceptableForSchool (println "Congratulation!")
      )
    )
  )

(defn process
  [schools students]

  (doseq [student students]
    (printStudentInfo schools (rand-int 100) student)
    )
  )

(process
  [
   {
    "name"  "Gryffindor",
    "range" [0 20]
    }
   {
    "name"  "Raven Claw",
    "range" [20 40]
    }
   {
    "name"  "Hufflepuff",
    "range" [40 60]
    }
   {
    "name"  "Slytherin",
    "range" [60 80]
    }
   {
    "name"  "škola zemědělská",
    "range" [80 100]
    }
   ]
  ["Harry Potter" "Ron Weasley" "Hermione Granger" "Draco Malfoy" "Luna Lovegood"]
  )
