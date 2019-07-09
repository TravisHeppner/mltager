# mltager
This project is meant to support a machine learning project I've been meaning to tackle.  In particular I'd like to take animation clips, split them up into localized frames (let's say 5), and be able to assign tags to these groupings.  
The ML project has three parts that I could use this information with.
  A) Make a classifier to guess at the tags that would associated with the frames.
  B) Feed the tag into a model along with the frames to generate inbetweens
  C) Filter training data by tag to:
    - Train on types of animation
    - Remove still shots cuts and otherwise clean the dataset
    
# Proposed workflow
A user would upload an animation clip, on server side the video would be pulled appart frame by frame and saved to the bucket.  At the same time references to frames would need to be added to the database.  This would happen as a sliding window of 5 frames.  So an animation clip would generate n - 5 sample documents containing references to 5 frames in the database with no tags.  The user would then be able to go through the sample documents and add tags.  This means we'll need to serve up each image from a sample document, provide a way to add tags or other meta data and save that off to another collection in the database.  Bonus if we can serve up suggestions from other people or the classifier later.  We'll also need a way to call a sample document done so it only appears once, and a way to skip documents.


# Tech stack
I'm thinking making this a webapp would be the best way to go about this as I could work on it from anywhere, maybe outsource it to others who know more about animation.  That being said I'm thinking using reagent, and material-ui for my front end, while using ring, and mongo db for my backend.  I'll also need some sort of filestore to hold all the images, which could either be a aws or google bucket.
