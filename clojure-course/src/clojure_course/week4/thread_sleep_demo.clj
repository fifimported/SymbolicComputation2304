(ns clojure-course.week4.thread-sleep-demo)

(defn sleep-demo []
  (println "Wait for it...")
  ; sleeps for 3 seconds
  (Thread/sleep 3000)
  (println "Here I am!"))

(sleep-demo)
