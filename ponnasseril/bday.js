var cuzinz = [
  {
    "name": "Rekha",
    "birthday": "9/19"
  },
  {
    "name": "Sunil",
    "birthday": "1/1"
  },
  {
    "name": "Ranjan",
    "birthday": "5/1"
  },
  {
    "name": "Roshan",
    "birthday": "4/18"
  },
  {
    "name": "Ranjit",
    "birthday": "1/6"
  },
  {
    "name": "Erica",
    "birthday": "3/9"
  },
  {
    "name": "Bavan",
    "birthday": "7/2"
  },
  {
    "name": "Anita",
    "birthday": "9/8"
  },
  {
    "name": "Swithin",
    "birthday": "4/20"
  },
  {
    "name": "Rena",
    "birthday": "7/8"
  },
  {
    "name": "Sherry",
    "birthday": "10/2"
  },
  {
    "name": "Sona",
    "birthday": "3/1"
  },
  {
    "name": "Shanu",
    "birthday": "12/27"
  },
  {
    "name": "Justin",
    "birthday": "6/14"
  },
  {
    "name": "Alex",
    "birthday": "5/17"
  },
  {
    "name": "Chris",
    "birthday": "12/11"
  },
  {
    "name": "Dinah",
    "birthday": "9/4"
  },
  {
    "name": "Sanu",
    "birthday": "7/11"
  },
  {
    "name": "Jwala",
    "birthday": "3/13"
  },
  {
    "name": "Priya",
    "birthday": "11/15"
  },
  {
    "name": "Shawn",
    "birthday": "9/28"
  },
  {
    "name": "Manna",
    "birthday": "3/1"
  },
  {
    "name": "Sarah",
    "birthday": "12/30"
  },
  {
    "name": "Hannah",
    "birthday": "9/20"
  },
  {
    "name": "Christian",
    "birthday": "12/8"
  }
];
for(var i=0; i<=cuzinz.length; i++) {
  var today = new Date();
  var now = (today.getMonth()+1) + "/" + today.getDate();
  console.log("Happy birthday " + cuzinz[i].name);
}
