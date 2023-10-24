(ns clojure-course.week5.caesar-cypher-roman-yepanchenko
  (:require [clojure.set :as clojure.set :only [map-invert]])
  )

(def alphabetString "ABCDEFGHIJKLMNOPQRSTUVWXYZ ")
(def letterToIndexMap (clojure.set/map-invert (into {} (map-indexed vector alphabetString))))

(defn calculateNewIndexes
  [indexes, offset]

  (let [
        letterToIndexMap letterToIndexMap
        index (atom 0)
        state (atom true)
        response (atom [])
        ]

    (while (= @state true)

      (if (<= (+ (get indexes @index) offset) (- (count letterToIndexMap) 1))
        (reset! response (conj @response (+ (get indexes @index) offset)))
        (reset! response (conj @response (- (+ (get indexes @index) offset) (- (count letterToIndexMap) 0))))
        )

      (reset! index (+ @index 1))

      (if (> @index (- (count indexes) 1))
        (reset! state false)
        )
      )

    @response
    )
  )

(defn process
  [word, offset]
  (apply str (into [] (map (fn [x] (get alphabetString x)) (calculateNewIndexes (into [] (map (fn [x] (get letterToIndexMap x)) word)) offset ))))
  )

(defn encrypt
  [word, offset]

  (process word offset)
  )

(defn decrypt
  [word, offset]

  (process word (- (count alphabetString) offset))
  )

(println(encrypt "CAESAR WAS AN ACCOMPLISHED AUTHOR AND HISTORIAN AS WELL AS A STATESMAN MUCH OF HIS LIFE IS KNOWN FROM HIS OWN ACCOUNTS OF HIS MILITARY CAMPAIGNS" 14))
(println(decrypt (encrypt "CAESAR WAS AN ACCOMPLISHED AUTHOR AND HISTORIAN AS WELL AS A STATESMAN MUCH OF HIS LIFE IS KNOWN FROM HIS OWN ACCOUNTS OF HIS MILITARY CAMPAIGNS" 14) 14))


