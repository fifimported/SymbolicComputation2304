(ns clojure-course.week6.dfs-2
  (:require [clojure-course.week6.tree-init-data :as tree])
  )

(defn get_node
  [node_name]
  (first (filter #(= node_name (:name %)) tree/all_nodes))
  )

; gets edges FROM the given node
(defn get_edges_for_node
  [node_name]
  (filter #(= node_name (:node_from %)) tree/all_edges)
  )

; return a node's children (also nodes)
(defn get_children_for_node
  [node_name]
  (let [edges_for_this_node (get_edges_for_node node_name)
        children (map get_node (->> edges_for_this_node (map :node_to)))
        ;_ (println "'" node_name "' children =>" children)
        ]
    children
    )
  )

(def root_node (get_node "root"))
(def num_of_iterations (atom 0))

(defn dfn_routines
  ; subset of nodes (objects)
  [nodes]
  (println "nodes=" nodes )
  (loop [current_node (first nodes)
         ]
    (println "current_node=" (:name current_node) )
    (if (nil? current_node)
      ; all nodes covered
      (println "nil!")
      (recur (first (rest nodes)))
      )

    )

  )

(dfn_routines (vector root_node))



