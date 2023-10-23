(ns clojure-course.week5.caesar-cypher-hidden
  (:require [clojure.string :as string :only [upper-case]])
  )

(def hidden_phrase_to_encode (string/upper-case "Lincoln was born into poverty in a log cabin in Kentucky and was raised on the frontier primarily in Indiana He was self educated and became a lawyer Whig Party leader Illinois state legislator and US congressman from Illinois he returned to his successful law practice in Springfield Illinois he was angered by the Kansas Nebraska Act which opened the territories to slavery causing him to re enter politics He soon became a leader of the new Republican Party He reached a national audience Senate campaign debates against Stephen Douglas Lincoln ran for president sweeping the North to gain victory"))
(def hidden_cypher_key (+ 1 (rand-int 5)))
;(println "hidden_cypher_key=" hidden_cypher_key)

