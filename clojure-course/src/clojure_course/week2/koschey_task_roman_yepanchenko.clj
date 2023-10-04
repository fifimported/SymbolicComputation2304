(ns clojure-course.week2.koschey-task-roman-yepanchenko)

(let
  [chest (fn [string]
           (let
             [duck (fn [string]
                     (let
                       [jackrabbit (fn [string]
                                     (let
                                       [needle (fn [string] (println string))
                                        _ (needle string)
                                        ]
                                       ))
                        _ (jackrabbit string)
                        ]
                       ))
              _ (duck string)
              ]
             ))
   _ (chest "needle is out from ...")
   ]
  )
