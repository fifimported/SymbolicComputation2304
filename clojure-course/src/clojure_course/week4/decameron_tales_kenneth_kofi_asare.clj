(ns clojure-course.week4.decameron-tales-kenneth-kofi-asare)

(defn narrate-begin[story]
  (when (seq story)
    (print (first story))
    (flush)
    (Thread/sleep 100)
    (recur (rest story))))

(defn narrate-end [ending]
  (doseq [char (.toCharArray ending)]
    (print (str char))
    (flush)
    (Thread/sleep 100)))

(defn narrate []
  (println "Wait for it...")
  (let [story "Simona loves Pasquino. They are together in a garden. Pasquino rubs a leaf of sage against his teeth, and dies. Simona is arrested. With intent to show the judge how Pasquino died, rubs one of the leaves of the same plant against her teeth,"
        ending " \nand likewise dies.!"]
    (narrate-begin story)
    (Thread/sleep 7000)
    (narrate-end ending)))

(narrate)


