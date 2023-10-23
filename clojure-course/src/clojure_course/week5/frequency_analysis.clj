(ns clojure-course.week5.frequency-analysis
  (:require [clojure-course.week5.caesar-cypher-init-data :as init_data])
  (:require [clojure-course.week5.caesar-cypher :as caesar])
  (:require [clojure-course.week5.caesar-cypher-hidden :as hidden])
  )

(defn calculate_stats [phrase]
  (let [stats (atom {}) ]
    (doseq [
            letter init_data/alphabet
            ]
      (reset! stats (assoc @stats letter 0))
      )
    ;(println "stats init=" @stats)
    (doseq [
            letter phrase
            ]
      (reset! stats (update @stats letter inc))
      )
    ;(reverse (sorted-map @stats))
    @stats
    )
  )

(println "length of phrase_to_encode=" (count hidden/hidden_phrase_to_encode))

(def encoded_phrase (caesar/conversion hidden/hidden_phrase_to_encode hidden/hidden_cypher_key "" caesar/encode_letter_routine))
(println "encoded_phrase=" encoded_phrase)

(println "stats=" (calculate_stats encoded_phrase))

