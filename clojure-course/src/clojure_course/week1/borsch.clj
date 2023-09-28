(ns clojure-course.week1.borsch)

;; Week 1 Lecture 2 27-Sep-2023
;; Usage of functions with simple arguments and functions as arguments

(defn boil
  [ingredient-name]
  (println ingredient-name "is boiled")
  )

(defn fry
  [ingredient-name]
  (println ingredient-name "is fried")
  )

(def borsch_ingredients ["beet" "potato" "carrot"])

(defn borsch
  []
    (println "Cooking borsch...")
    (boil_all borsch_ingredients)
    (doseq [ingredient_name borsch_ingredients]
      (boil ingredient_name)
      (fry ingredient_name)
    )
    (println "Mix all together...")
    (println "Done!")
  )

(defn cook
  ;; NOTE: this is a pointer to a function! Not "dish name" but dish itself.
  [dish]
  (dish)
  (println "Bon appetit!")
  )

(cook borsch)
