(ns clojure-course.week2.sorting-hat-dea-rrecaj)

(defn assign-house [random-num]
  (cond
    (and (>= random-num 0) (< random-num 25)) "Gryffindor"
    (and (>= random-num 25) (< random-num 50)) "Ravenclaw"
    (and (>= random-num 50) (< random-num 75)) "Hufflepuff"
    :else "Slytherin"))

(def students [
               "Harry Potter" "Ron Weasley" "Hermione Granger"
               "Draco Malfoy" "Neville Longbottom" "Luna Lovegood"])

(doseq [student students]
  (let [random-num (rand-int 100) ; Generate a random number between 0 and 99
        house (assign-house random-num)]
    (println (str student " is in " house))
    (println (str "Congratulations, " student "!\n"))))
