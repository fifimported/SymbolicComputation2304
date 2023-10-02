(ns clojure-course.week1.interview-task-2-bear-trading-roman-yepanchenko)

(defn findTheBestSellDay
  [values]

  (def dayIndex -1)
  (def dayValue 0)

  (doseq [[i1 value] (map-indexed vector values)]

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
  [values minIndex]

  (def dayIndex -1)
  (def dayValue -1)
  (def isInitialized false)

  (doseq [[i1 value] (map-indexed vector values)]

    (when (> i1 minIndex)
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
  (def comissionPercent (+ (get day1Data 0) 0.25))

  (println "(sell) Day 1 index/value:" (get day2Data 0) (get day2Data 1))
  (println "(buy) Day 2 index/value:" (get day1Data 0) (get day1Data 1))
  (println "Commission/Price after commission:" comissionPercent (- (get day1Data 1) (* (get day1Data 1) (/ comissionPercent 100))))
  )

(process [7 1 5 3 6 25 4 3 4 14])
