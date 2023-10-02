(ns clojure-course.week1.interview-task-2-roman-yepanchenko)

(defn findTheBestSellDay
  [values]

  (def dayIndex -1)
  (def dayValue 0)

  (doseq [[i1 value] (map-indexed vector values)]
    ;(println "start" value)
    (when (> i1 0)
      (when (> value dayValue)
        (def dayIndex i1)
        (def dayValue value)
        )
      )
    )

  (let [response [dayIndex, dayValue]] response)
  )
(defn findTheBestBuyDay
  [values maxIndex]

  (def dayIndex -1)
  (def dayValue -1)
  (def isInitialized false)

  (doseq [[i1 value] (map-indexed vector values)]
    (when (< i1 maxIndex)
      (when (or (< value dayValue) (= isInitialized false))
        (def dayIndex i1)
        (def dayValue value)
        (def isInitialized true)
        )
      )
    )

  (let [response [dayIndex, dayValue]] response)
  )

; Naive algorithm

(defn process
  [values]

  (def day2Data (findTheBestSellDay values))
  (def day1Data (findTheBestBuyDay values (get day2Data 0)))

  (when (= (get day1Data 1) (get day2Data 1))
    (println 0)
    )

  (when (not (= (get day1Data 1) (get day2Data 1)))
    (println "(buy) Day 1 index/value" (get day1Data 0) (get day1Data 1))
    (println "(sell) Day 2 index/value" (get day2Data 0) (get day2Data 1))
    )
  )

(process [7 1 5 3 6 4])
