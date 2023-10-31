



function draw() {
    var container = document.getElementById("network");

    var data = {
        nodes: nodes,
        edges: edges,
    };

    var options = {
        nodes: {
          borderWidth: 4,
          size: 30,
          color: {
            border: "#222222",
            background: "#666666",
          },
          font: { color: "#eeeeee" },
        },

        edges: {
          color: "lightgray",
        }
    };
    network = new vis.Network(container, data, options);
}

window.addEventListener("load", () => {
  draw();
});


