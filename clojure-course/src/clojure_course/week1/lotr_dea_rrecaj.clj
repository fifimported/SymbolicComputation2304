(ns clojure-course.week1.lotr-dea-rrecaj)

;; Week 1 Lecture 1 25-Sep-2023
;; Basic Clojure calculation in REPL
;; Author: Dea Rrecaj

(defn main []
  (def fsb {:Frodo-Baggins 50
            :Samwise-Gamgee 38
            :Bilbo-Baggins 128})

  (def aa {:Aragorn 87
           :Arwen-Undomiel 2777})

  (def total-hobbit-age (reduce + (vals fsb)))
  (def age-difference (- (:Arwen-Undomiel aa) (:Aragorn aa)))

  (println "Total age of hobbits:" total-hobbit-age)
  (println "Age difference between Arwen and Aragorn:" age-difference))

(main)
