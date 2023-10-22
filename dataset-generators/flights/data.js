const imgFolder = 'img/';
const nodes = [
{ id: 1, shape: 'circularImage', image: imgFolder + 'Warsaw.jpg', label: 'Warsaw'  },
{ id: 2, shape: 'circularImage', image: imgFolder + 'Krakov.jpg', label: 'Krakov'  },
{ id: 3, shape: 'circularImage', image: imgFolder + 'Budapest.jpg', label: 'Budapest'  },
{ id: 4, shape: 'circularImage', image: imgFolder + 'Rijeka.jpg', label: 'Rijeka'  },
{ id: 5, shape: 'circularImage', image: imgFolder + 'Zagreb.jpg', label: 'Zagreb'  },
{ id: 6, shape: 'circularImage', image: imgFolder + 'Napoli.jpg', label: 'Napoli'  },
{ id: 7, shape: 'circularImage', image: imgFolder + 'Rome.jpg', label: 'Rome'  },
{ id: 8, shape: 'circularImage', image: imgFolder + 'Innsbruck.jpg', label: 'Innsbruck'  },
{ id: 9, shape: 'circularImage', image: imgFolder + 'Vienna.jpg', label: 'Vienna'  },
{ id: 10, shape: 'circularImage', image: imgFolder + 'Prague.jpg', label: 'Prague'  },
{ id: 11, shape: 'circularImage', image: imgFolder + 'Berlin.jpg', label: 'Berlin'  },
{ id: 12, shape: 'circularImage', image: imgFolder + 'Hamburg.jpg', label: 'Hamburg'  },
{ id: 13, shape: 'circularImage', image: imgFolder + 'Munich.jpg', label: 'Munich'  },
{ id: 14, shape: 'circularImage', image: imgFolder + 'Brno.jpg', label: 'Brno'  }];
const edges = [
{ from: 2, to: 1, label: '100' },
{ from: 12, to: 11, label: '100' },
{ from: 1, to: 11, label: '300' },
{ from: 10, to: 11, label: '200' },
{ from: 13, to: 11, label: '100' },
{ from: 13, to: 8, label: '100' },
{ from: 9, to: 8, label: '200' },
{ from: 9, to: 3, label: '300' },
{ from: 1, to: 3, label: '400' },
{ from: 5, to: 3, label: '200' },
{ from: 9, to: 7, label: '400' },
{ from: 6, to: 7, label: '200' },
{ from: 6, to: 4, label: '100' },
{ from: 9, to: 10, label: '200' },
{ from: 9, to: 4, label: '400' },
{ from: 4, to: 5, label: '100' },
{ from: 9, to: 5, label: '300' },
{ from: 13, to: 5, label: '400' },
{ from: 8, to: 7, label: '400' },
{ from: 3, to: 7, label: '400' },
{ from: 3, to: 11, label: '300' },
{ from: 10, to: 14, label: '100' },
{ from: 10, to: 3, label: '300' }];
