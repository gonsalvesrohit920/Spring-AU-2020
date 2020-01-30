import * as React from 'react';
import {View, StyleSheet, Dimensions} from 'react-native';
import {TabView, SceneMap} from 'react-native-tab-view';
import Books from './Books';

// Romance Genre
const FirstRoute = () => (
  <View genre="Romance" style={[styles.scene, styles.romance]}>
    <Books genre="romance" />
  </View>
);

// Thriller Genre
const SecondRoute = () => (
  <View genre="Thriller" style={[styles.scene, styles.thriller]}>
    <Books genre="thriller" />
  </View>
);

//horror Genre
const ThirdRoute = () => (
  <View genre="Horror" style={[styles.scene, styles.horror]}>
    <Books genre="horror" />
  </View>
);

const initialLayout = {width: Dimensions.get('window').width};

export default function TabViewExample() {
  const [index, setIndex] = React.useState(0);
  const [routes] = React.useState([
    {key: 'first', title: 'Romance'},
    {key: 'second', title: 'Thriller'},
    {key: 'third', title: 'Horror'},
  ]);

  const renderScene = SceneMap({
    first: FirstRoute,
    second: SecondRoute,
    third: ThirdRoute,
  });

  return (
    <TabView
      navigationState={{index, routes}}
      renderScene={renderScene}
      onIndexChange={setIndex}
      initialLayout={initialLayout}
    />
  );
}

const styles = StyleSheet.create({
  scene: {
    flex: 1,
  },
  romance: {
    backgroundColor: 'violet',
  },
  thriller: {
    backgroundColor: 'goldenrod',
  },
  horror: {
    backgroundColor: 'black',
  },
});
