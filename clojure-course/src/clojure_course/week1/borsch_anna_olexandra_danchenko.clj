(ns clojure-course.week1.borsch-anna-olexandra-danchenko)

;; Week 1 Lecture 2 27-Sep-2023
;; Usage of functions with simple arguments and functions as arguments
;; Author: Anna-Olexandra Danchenko

(defn boiling [name]
  (println name "are boiled"))

(defn frying [name]
  (println name "are fried"))
(boiling "Carrots")
(frying "Carrots")

(def ingridients ["beets" "potato" "carrot"])

(defn borsch [ingridients]
  (boiling ingridients)
  (println "Ready!"))

(borsch ingridients)

