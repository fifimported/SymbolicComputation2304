(ns clojure-course.week6.dfs_bfs_1
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

(defn dfs_routines
  ; node -- object
  [node]
  (println "processing" (:name node))
  (swap! num_of_iterations inc)
  (if (true? (:find_me node))
    node
    (let [children (get_children_for_node (:name node))
          node_found (atom nil)
          ]
      (doseq [node_child children]
        (when (nil? @node_found)
          ;(println "node_child =" node_child)
          (reset! node_found (dfs_routines node_child))
          (println "node_found=" @node_found "; called from=" (:name node))
          )
        )

      @node_found
      )
    )
  )

;(println "result (DFS) =" (dfs_routines root_node))
;(println "number of iterations (DFS) =" @num_of_iterations)

; reset
(def num_of_iterations (atom 0))

(defn bfs_routines
  ; nodes -- list of objects
  [nodes]
  (println "processing nodes ->"nodes)
  (let [node_found (atom nil)]
    ; check all node at the given depth
    (doseq [node nodes]
      (when (nil? @node_found)
        (when (true? (:find_me node))
          (swap! num_of_iterations inc)
          (reset! node_found node)
        )
      )
     )
    ; go to children
    (when (nil? @node_found)
      (doseq [node nodes]
        (when (nil? @node_found)
          (swap! num_of_iterations inc)
          (reset! node_found (bfs_routines (get_children_for_node (:name node))))
          )
        )
      )

    @node_found
    )
  )

(println "result (BFS) =" (bfs_routines (get_children_for_node (:name root_node))))
(println "number of iterations (BFS) =" @num_of_iterations)