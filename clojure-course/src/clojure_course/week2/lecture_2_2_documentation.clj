(ns clojure-course.week2.lecture-2-2-documentation
  (:use [clojure.repl :only [doc source]])
  (:require [clojure-course.week2.lecture_2_2_let :refer [let-demo] :as l22 ])
  )

(doc empty?)
(source empty?)
(source while)
(let-demo)
(source l22/dummy_func)


