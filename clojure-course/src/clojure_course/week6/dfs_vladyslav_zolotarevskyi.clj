(ns clojure-course.week6.dfs-vladyslav-zolotarevskyi
  (:require [clojure-course.week6.tree-init-data :as tree])
  )

(defn dfs-search
  [start-node]
  (let [visited (set [start-node])]

    (defn dfs [current-node]
      (when current-node
        (println (str "Visiting node: " (:name current-node)))
        (if (:find_me current-node)
          (println "Found the target node with value true!")
          (doseq [edge tree/all_edges
                  :when (= (:node_from edge) (:name current-node))
                  :let [next-node (first (filter #(= (:name %) (:node_to edge)) tree/all_nodes))]
                  :when (not (contains? visited next-node))]
            (dfs next-node))))
      )
    (dfs start-node))
  )


(dfs-search (first tree/all_nodes))



