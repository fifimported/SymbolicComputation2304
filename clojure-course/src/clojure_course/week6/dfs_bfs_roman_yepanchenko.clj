(ns clojure-course.week6.dfs_bfs_roman_yepanchenko
  (:require [clojure-course.week6.tree-init-data :as init-data])
  )

(let
  [
   currentNodes (atom [["root"]])
   children (atom [])
   nextNodes (atom [])
   state (atom true)
   steps (atom 0)
   ]

  (while (= @state true)

    (doseq [nodePack @currentNodes]

      (doseq [nodeName nodePack]
        (doseq [value init-data/all_nodes]
          (if (= (get value :name) nodeName)
            (do

              (if (and (= (get value :find_me) true) (= @state true))
                (do

                  (println "FOUND")
                  (println (get value :name))
                  (reset! state false)

                  )

                (do
                  (doseq [value init-data/all_edges]
                    (if (= (get value :node_from) nodeName)
                      (reset! children (conj @children (get value :node_to)))
                      )
                    )
                  )
                )


              (reset! nextNodes (conj @nextNodes @children))
              )
            )
          )
        )
      )

    (reset! steps (+ @steps 1))

    (if (= @steps 100)
      (do
        (println "out of steps")
        (reset! state false)
        )
      )

    (if (= (count @nextNodes) 0)
      (do
        (reset! state false)
        (reset! currentNodes [])
        )
      (do
        (reset! currentNodes @nextNodes)
        (reset! nextNodes [])
        (reset! children [])

        )
      )
    )

  )




